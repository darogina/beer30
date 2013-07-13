package com.github.darogina.beer30.controller.api.v1;

import com.github.darogina.beer30.model.api.v1.StatusType;
import org.modelmapper.ModelMapper;
import org.resthub.test.AbstractWebTest;
import org.resthub.web.exception.NotFoundClientException;
import org.testng.annotations.Test;

import static org.fest.assertions.api.Assertions.assertThat;

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
        assertThat(statusType1).isNotNull();
        assertThat(statusType2).isNotNull();
        assertThat(statusType1.getId()).isNotNull();
        assertThat(statusType2.getId()).isNotNull();
    }

    @Test
    public void testUpdate() {
        StatusType originalStatusType = this.request(BASE_REQUEST_MAPPING).jsonPost(new StatusType(null, "Stop", "dont drink")).resource(StatusType.class);
        assertThat(originalStatusType).isNotNull();

        originalStatusType.setName("GO");
        originalStatusType.setDescription("Drink Up!");
        StatusType updatedStatusType = this.request(String.format("%s/%s", BASE_REQUEST_MAPPING, originalStatusType.getId())).jsonPut(originalStatusType).resource(StatusType.class);

        assertThat(updatedStatusType).isNotNull();
        assertThat(updatedStatusType.getId()).isEqualTo(originalStatusType.getId());
        assertThat(updatedStatusType.getName()).isEqualTo("GO");
        assertThat(updatedStatusType.getDescription()).isEqualTo("Drink Up!");
    }

    @Test(expectedExceptions = NotFoundClientException.class)
    public void testDelete() {
        StatusType originalStatusType = this.request(BASE_REQUEST_MAPPING).jsonPost(new StatusType(null, "Stop", "dont drink")).resource(StatusType.class);
        assertThat(originalStatusType).isNotNull();

        this.request(String.format("%s/%s", BASE_REQUEST_MAPPING, originalStatusType.getId())).delete();

        // Expect that a NotFoundClientException will be thrown
        this.request(String.format("%s/%s", BASE_REQUEST_MAPPING, originalStatusType.getId())).jsonGet();
    }

}