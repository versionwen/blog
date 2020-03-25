package com.version.Service;

import com.version.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * @author version
 * @version 1.0
 * @date 2020/3/25 17:51
 */
public interface TypeService {
    Type saveType(Type type);
    Optional<Type> getType(Long id);
    Page<Type>ListType(Pageable pageable);
    Type updateType(Long id,Type type);
    void delectType(Long id);
}
