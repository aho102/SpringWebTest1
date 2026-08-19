package io.virinchi.springwebtest1.Repository;

import io.virinchi.springwebtest1.Model.VirImgTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<VirImgTable,Integer> {

}
