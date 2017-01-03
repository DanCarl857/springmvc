package daniel.springframework.services;

import daniel.springframework.domain.DomainObject;

import java.util.*;

/**
 * Created by daniel on 1/3/17.
 */
public abstract class AbstractMapService {

    protected Map<Integer, DomainObject> domainMap;

    public AbstractMapService() {
        domainMap = new HashMap<>();
        loadDomainObjects();
    }

    public List<DomainObject> listAll() { return new ArrayList<>(domainMap.values()); }

    public DomainObject getById(Integer id) { return domainMap.get(id); }

    public DomainObject saveOrUpdate(DomainObject domainObject){
        if(domainObject != null){

            if(domainObject.getId() == null){
                domainObject.setId(getNextKey());
            }
            domainMap.put(domainObject.getId(), domainObject);

            return domainObject;
        } else {
            throw new RuntimeException("Object can't be null");
        }
    }

    public void delete(Integer id) { domainMap.remove(id); }

    public Integer getNextKey() { return Collections.max(domainMap.keySet()); }

    protected abstract void loadDomainObjects();
}
