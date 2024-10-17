package com.core.pilot.port;

import com.core.pilot.adapter.model.FirstDocument;

import java.util.List;


public interface DocumentServiceI {

    List<FirstDocument> getAllFirstDocuments();

    FirstDocument createFirstDocument(FirstDocument firstDocument);
}
