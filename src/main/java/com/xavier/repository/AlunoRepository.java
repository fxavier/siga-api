package com.xavier.repository;

import com.xavier.model.Aluno;
import com.xavier.repository.filter.AlunoFilter;

import java.util.HashMap;
import java.util.List;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {
    public List<Aluno> findByIds(List<Long> ids) {
        return list("id in ?1", ids);
    }

/*     public List<Aluno> filter(Map<String, Object> filters, int page, int size) {
        String query = "";
        if (!filters.isEmpty()) {
            query = filters.entrySet().stream()
                    .map(entry -> entry.getKey() + " like :" + entry.getKey())
                    .reduce((a, b) -> a + " or " + b).orElse("");
        }
        return find(query, filters).page(page, size).list();
    }

    public long count(Map<String, Object> filters) {
        String query = "";
        if (!filters.isEmpty()) {
            query = filters.entrySet().stream()
                    .map(entry -> entry.getKey() + " like :" + entry.getKey())
                    .reduce((a, b) -> a + " and " + b).orElse("");
        }
        return find(query, filters).count();
    }
 */
    public List<Aluno> findByFilter(AlunoFilter filter, int page, int size) {
        StringBuilder query = new StringBuilder("1 = 1");
        HashMap<String, Object> params = new HashMap<>();
        if (filter.getPrimeiroNome() != null) {
            query.append(" and primeiroNome like :primeiroNome");
            params.put("primeiroNome", "%" + filter.getPrimeiroNome() + "%");
        }
        if (filter.getSegundoNome() != null) {
            query.append(" and segundoNome like :segundoNome");
            params.put("segundoNome", "%" + filter.getSegundoNome() + "%");
        }

        if (filter.getApelido() != null) {
            query.append(" and apelido like :apelido");
            params.put("apelido", "%" + filter.getApelido() + "%");
            
        }

        if (filter.getNumero() != null) {
            query.append(" and numero like :numero");
            params.put("numero", "%" + filter.getNumero() + "%");
            
        }

        return find(query.toString(), params).page(page, size).list();

    }
    
}
