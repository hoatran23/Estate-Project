//package com.laptrinhjavaweb.repository.custom.implCustom;
//
//import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
//import com.laptrinhjavaweb.repository.custom.AssignmentBuildingRepositoryCustom;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//import java.util.List;
//
//public class AssignmentBuildingRepositoryCustomImpl implements AssignmentBuildingRepositoryCustom {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
////    @Override
////    public List<AssignmentBuildingEntity> findAllByBuildingId(Long buildingId) {
////        StringBuilder sql = new StringBuilder("SELECT * FROM assignmentbuilding ab");
////        sql.append("\nWHERE ab.buildingid = " + buildingId);
////        Query query = entityManager.createNativeQuery(sql.toString(), AssignmentBuildingEntity.class);
////        return query.getResultList();
////    }
//}
