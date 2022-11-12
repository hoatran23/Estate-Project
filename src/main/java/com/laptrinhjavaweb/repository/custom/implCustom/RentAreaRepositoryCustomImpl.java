package com.laptrinhjavaweb.repository.custom.implCustom;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class RentAreaRepositoryCustomImpl implements RentAreaRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RentAreaEntity> findRentAreaByBuildingId(Long buildingId) {
        StringBuilder sql = new StringBuilder("SELECT ra.* FROM building b JOIN rentarea ra ON b.id = ra.buildingid where ra.buildingid =");
        sql.append(buildingId);
        Query query = entityManager.createNativeQuery(sql.toString(), RentAreaEntity.class);
        return query.getResultList();
    }
}
