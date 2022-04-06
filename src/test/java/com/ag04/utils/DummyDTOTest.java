package com.ag04.utils;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class DummyDTOTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DummyDTO.class);
        DummyDTO dto1 = new DummyDTO();
        dto1.setId(1L);
        DummyDTO dto2 = new DummyDTO();

        dto2.setId(dto1.getId());
        assertThat(dto1).isEqualTo(dto2);
        dto2.setId(2L);
        assertThat(dto1).isNotEqualTo(dto2);
        dto1.setId(null);
        assertThat(dto1).isNotEqualTo(dto2);
    }
}
