package br.com.github.davimc.ItSupport.repositories;

import br.com.github.davimc.ItSupport.dto.projections.JobView;
import br.com.github.davimc.ItSupport.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface JobRepository extends JpaRepository<Job, UUID> {
//todo está errado a forma de chamar o tb_tasks, tem que comparar o id
    // todo fazer join com usuário para que busque o cliente e técnico
   @Query("SELECT J.OS, J.STATUS, J.CREATED_AT, J.TYPE, J.FINISHED_AT, J.ID,SUM(T.AMOUNT) AS TOTAL,  C.NAME AS CLIENT_NAME, U_TEC.NAME AS TECH_NAME" +
            "FROM tb_jobs AS J" +
            "INNER JOIN tb_tasks AS T ON J.ID = T.JOB_ID" +
            "INNER JOIN tb_jobs_devices AS JD ON J.ID = JD.JOB_ID" +
            "INNER JOIN tb_devices AS D ON D.ID = JD.DEVICE_ID" +
            "INNER JOIN tb_users AS U_TEC ON U_TEC.ID = J.TECHNICIAN_ID " +
            "INNER JOIN tb_users AS C ON C.ID = D.OWNER_ID " +
            "GROUP BY J.OS, J.STATUS, J.CREATED_AT, J.FINISHED_AT, J.ID, C.NAME, U_TEC.NAME;")
   Page<JobView> findAllJobView(Pageable pageable);
}
