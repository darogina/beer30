package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.model.api.v1.StatusType;
import org.fest.assertions.api.Assertions;
import org.modelmapper.ModelMapper;
import org.resthub.test.AbstractWebTest;
import org.testng.annotations.Test;

public class StatusTypeAPIv1ControllerTest extends AbstractWebTest {

    private static final String BASE_REQUEST_MAPPING = "api/v1/statusType";

    private ModelMapper mapper = new ModelMapper();

    public StatusTypeAPIv1ControllerTest() {
        // Activate resthub-web-server and resthub-jpa Spring profiles
        super("resthub-web-server,resthub-jpa");
    }

    @Test
    public void testFindById() {
        StatusType statusType1 = this.request(BASE_REQUEST_MAPPING).jsonPost(new StatusType(null, "Stop", "dont drink")).resource(StatusType.class);
        StatusType statusType2 = this.request(BASE_REQUEST_MAPPING).jsonPost(new StatusType(null, "Go", "drink up")).resource(StatusType.class);
        Assertions.assertThat(statusType1).isNotNull();
        Assertions.assertThat(statusType2).isNotNull();
        Assertions.assertThat(statusType1.getId()).isNotNull();
        Assertions.assertThat(statusType2.getId()).isNotNull();
    }

}