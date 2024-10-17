package com.core.pilot.core;

import com.core.pilot.adapter.FirstDocumentRepo;
import com.core.pilot.adapter.model.FirstDocument;
import com.core.pilot.port.DocumentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService implements DocumentServiceI {

    @Autowired
    FirstDocumentRepo firstDocumentRepo;

    @Override
    public List<FirstDocument> getAllFirstDocuments() {
        return firstDocumentRepo.findAll();
    }

    @Override
    public FirstDocument createFirstDocument(FirstDocument firstDocument) {
        return firstDocumentRepo.save(firstDocument);
    }
}
