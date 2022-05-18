package ru.basecrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.basecrud.dto.ConsumerDTO;
import ru.basecrud.entity.Consumer;
import ru.basecrud.repository.ConsumerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    public List <Consumer> getUserList(){
        List<Consumer> all = consumerRepository.findAll();
        return all;
    }

    @Transactional
    public void createUser(ConsumerDTO consumerDTO) {
        Consumer consumer=new Consumer();
        consumer.setFirstName(consumerDTO.getFirstName());
        consumer.setLastName(consumerDTO.getLastName());
        consumer.setAge(consumerDTO.getAge());
        consumerRepository.save(consumer);
    }


    @Transactional
    public void updateUser(ConsumerDTO consumerDTO, Long id) {
        Consumer consumerExist = consumerRepository.findById(id).get();
        consumerExist.setFirstName(consumerDTO.getFirstName());
        consumerExist.setLastName(consumerDTO.getLastName());
        consumerExist.setAge(consumerDTO.getAge());
        consumerRepository.save(consumerExist);
    }

    @Transactional
    public void removeUser(Long id){
        Consumer consumerExist = consumerRepository.findById(id).get();
        consumerRepository.delete(consumerExist);
    }
}
