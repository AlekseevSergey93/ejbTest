package com.swemel.cassandra;

public class Pagination {
//        if (isEnd(httpSession) && !clearFlag) {
//            return new ArrayList<>();
//        }
//        Query query = null;
//        Slice<RequestJournalEntity> slice = null;
//        Pageable pageable = (CassandraPageRequest) httpSession.getAttribute("pageable");
//        PagingState state = null;
//        if (clearFlag) {
//            pageable = null;
//        }
//        String pagingState = pageable != null ? ((CassandraPageRequest) pageable).getPagingState().toString() : null;
//        if (clearFlag || pagingState == null) {
//            query = Query.query(where("username").is(username)).withAllowFiltering().pageRequest(CassandraPageRequest.first(10));
//        } else {
//            state = PagingState.fromString(pagingState);
//            query = Query.query(where("username").is(username)).withAllowFiltering().pageRequest(CassandraPageRequest.of(pageable, state));
//        }
//
//        slice = cassandraTemplate.slice(query, RequestJournalEntity.class);
//        if (slice.hasNext() && slice.hasContent()) {
//            pageable = slice.nextPageable();
//            httpSession.setAttribute("pageable", pageable);
//            return slice.getContent();
//        }
//        if (!slice.hasNext() && slice.hasContent()) {
//            httpSession.setAttribute("end", true);
//            return slice.getContent();
//        }
}
