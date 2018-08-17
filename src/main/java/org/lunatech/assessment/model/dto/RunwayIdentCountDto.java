package org.lunatech.assessment.model.dto;

/**
 * Created by m.fazel on 8/15/2018.
 */
public class RunwayIdentCountDto {

    public RunwayIdentCountDto(String runwayIdentification, Long count) {
        this.runwayIdentification = runwayIdentification;
        this.count = count;
    }

    private String runwayIdentification;
    private Long count;

    public String getRunwayIdentification() {
        return runwayIdentification;
    }

    public void setRunwayIdentification(String runwayIdentification) {
        this.runwayIdentification = runwayIdentification;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
