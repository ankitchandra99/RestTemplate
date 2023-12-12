package com.example.ankit.Repository;

import com.example.ankit.Entity.IpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IpInfoRepository extends JpaRepository<IpInfo,Long> {
    Optional<IpInfo> findByQuery(String query);
}
