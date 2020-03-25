package com.version.Service;

import com.version.dao.TypeRepository;
import com.version.po.Type;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/25 17:55
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    @Transactional
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    @Transactional
    public Optional<Type> getType(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    @Transactional
    public Page<Type> ListType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Type updateType(Long id, Type type) {
        Optional<Type> t=typeRepository.findById(id);
        if(t==null){
            try {
                throw new NotFoundException("no exist");
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }

    @Override
    public void delectType(Long id) {

    }
}
