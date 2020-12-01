package dto;

import exceptions.DuplicateRequestException;

import java.util.HashSet;
import java.util.Set;

public class Host {
    private Set<Request> requestSet = new HashSet<>();

    public void addRequest(Request r) throws DuplicateRequestException {
        if (requestSet.contains(r)) {
            throw new DuplicateRequestException();
        }
        requestSet.add(r);
    }
}
