package com.laptrinhjavaweb.repository.custom.implCustom;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.security.utils.SecurityUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;

public class BuildingRepositoryCustomImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findBuilding(BuildingSearchBuilder buildingBuilder) {
        StringBuilder sql = new StringBuilder("SELECT * FROM building b");

        sql = buildSqlJoining(buildingBuilder, sql);
        sql.append("\n" + SystemConstant.ONE_EQUAL_ONE);
        sql = buildSqlCommon(buildingBuilder, sql);
        sql = buildSqlSpecial(buildingBuilder, sql);
        sql.append("\nGROUP BY b.id");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder buildSqlJoining(BuildingSearchBuilder buildingBuilder, StringBuilder sql) {
        Long staffId = buildingBuilder.getStaffId();
        Integer rentareaFrom = buildingBuilder.getRentAreaFrom();
        Integer rentareaTo = buildingBuilder.getRentAreaTo();

        if (staffId != null) {
            sql.append("\nJOIN assignmentbuilding ab ON ab.buildingid = b.id");
            sql.append("\nJOIN users u ON ab.staffid = u.id");
        }

        if (rentareaFrom != null || rentareaTo != null) {
            sql.append("\nJOIN rentarea ra ON b.id = ra.buildingid");
        }
        return sql;
    }

    private StringBuilder buildSqlCommon(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if	(!fieldName.equals("staffId") && !fieldName.equals("districtCode") &&
                    !fieldName.startsWith("rentArea") && !fieldName.startsWith("rentPrice")) {
                    Object objectValue = field.get(buildingSearchBuilder);
                    String fieldType = field.getType().getName();
                    if (objectValue != null) {
                        if (fieldType.equals("java.lang.String")) {
                            if (field.get(buildingSearchBuilder) != null) {
                                sql.append("\nAND b." + field.getName().toLowerCase() + " LIKE '%"
                                        + field.get(buildingSearchBuilder).toString() + "%'");
                            }
                        } else if (fieldType.equals("java.lang.Integer")) {
                            if (field.get(buildingSearchBuilder) != null) {
                                sql.append("\nAND b." + field.getName().toLowerCase() + " = "
                                        + field.get(buildingSearchBuilder) + "");
                            }
                        } else if (fieldType.equals("java.lang.Double")) {
                            if (field.get(buildingSearchBuilder) != null) {
                                sql.append("\nAND b." + field.getName().toLowerCase() + " = "
                                        + field.get(buildingSearchBuilder) + "");
                            }
                        }
                    }
                }
            }
            return sql;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private StringBuilder buildSqlSpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) {
        String districtCode =  buildingSearchBuilder.getDistrictCode();
        Long staffId =  buildingSearchBuilder.getStaffId();
        Integer rentareaFrom = buildingSearchBuilder.getRentAreaFrom();
        Integer rentareaTo = buildingSearchBuilder.getRentAreaTo();
        Integer rentpriceFrom = buildingSearchBuilder.getRentPriceFrom();
        Integer rentpriceTo = buildingSearchBuilder.getRentPriceTo();

        if (districtCode != null) {
            sql.append("\nAND b.districtcode = '" + districtCode + "'");
        }
        if (staffId != null) {
            sql.append("\nAND u.id = " + staffId);
        }

        if (rentareaFrom != null) {
            sql.append("\nAND ra.value >= " + rentareaFrom);
        }
        if (rentareaTo != null) {
            sql.append("\nAND ra.value <= " + rentareaTo);
        }

        if (rentpriceFrom != null) {
            sql.append("\nAND b.rentprice >=  " + rentpriceFrom);
        }
        if (rentpriceTo != null) {
            sql.append("\nAND b.rentprice <= " + rentpriceTo);
        }
        return sql;
    }

    @Override
    public List<BuildingEntity> findBuildingByStaffId(Long staffId) {
        StringBuilder sql = new StringBuilder("SELECT b.* FROM building b JOIN assignmentbuilding ab");
        sql.append("\nON b.id = ab.buildingid");
        sql.append("\nWHERE ab.staffid = " + staffId);
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }
}
