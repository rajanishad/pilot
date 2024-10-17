package com.core.pilot.adapter;

import com.core.pilot.adapter.model.FirstDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstDocumentRepo  extends MongoRepository<FirstDocument,String> {
}
