package com.insta.humanoid.custom;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.brunocvcunha.instagram4j.requests.InstagramPostRequest;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class InstagramLikeCommentRequest extends InstagramPostRequest<String> {

    private Long id;

    public InstagramLikeCommentRequest(Long id){
        this.id=id;
    }
    @Override
    public String getUrl() {
        return "media/"+id+"/comment_like/";
    }

    public String getPayload() {
        try {
            Map<String, Object> likeMap = new LinkedHashMap();
            likeMap.put("_uuid", this.api.getUuid());
            likeMap.put("_uid", this.api.getUserId());
            likeMap.put("_csrftoken", this.api.getOrFetchCsrf());
            likeMap.put("comment_id", this.id);
            ObjectMapper mapper = new ObjectMapper();
            String payloadJson = mapper.writeValueAsString(likeMap);
            return payloadJson;
        } catch (Exception e) {
            try {
                throw e;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public String parseResult(int i, String s) {
        return "ok";
    }
}
