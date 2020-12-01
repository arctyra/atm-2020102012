package dto;

import exceptions.DuplicateRequestException;

import java.util.*;

public class Host {
    private Set<Request> requestSet = new HashSet<>();
    private Deque<Request> requestDeque = new ArrayDeque<>();

    public void addRequest(Request r) throws DuplicateRequestException {
        if (requestSet.contains(r)) {
            throw new DuplicateRequestException();
        }
        requestSet.add(r);
        requestDeque.add(r);
    }
}
