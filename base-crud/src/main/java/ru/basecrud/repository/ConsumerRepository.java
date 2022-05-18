package ru.basecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.basecrud.entity.Consumer;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
}
