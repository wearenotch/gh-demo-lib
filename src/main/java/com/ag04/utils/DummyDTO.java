package com.ag04.utils;

/**
 * Simple POJO.
 * 
 * @author dmadunic
 */
public class DummyDTO {
    private Long id;
    private String code;

    public DummyDTO() {
        //
    }

    public DummyDTO(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TestDTO [code=" + code + ", id=" + id + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DummyDTO)) {
            return false;
        }
        return id != null && id.equals(((DummyDTO) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }
    
}