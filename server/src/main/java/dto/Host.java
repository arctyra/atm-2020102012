package dto;

import exceptions.DuplicateRequestException;

import java.util.*;

public class Host {
    private final Set<Request> requestSet = new HashSet<>();
    private final Deque<Request> requestDeque = new ArrayDeque<>();

    public void addRequest(Request r) throws DuplicateRequestException {
        if (requestSet.contains(r)) {
            throw new DuplicateRequestException(r.toString());
        }
        requestSet.add(r);
        requestDeque.add(r);
    }
}
