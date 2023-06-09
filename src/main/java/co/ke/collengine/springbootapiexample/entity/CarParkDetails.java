package co.ke.collengine.springbootapiexample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class CarParkDetails {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @NotEmpty
  @JsonProperty("parking_name")
  private String parkingName;
  @NotEmpty
  private String lpn;
  @JsonProperty("time_in")
  private int  timeIn;
  @JsonProperty("time_out")
  private int  timeOut;
  private String color;

  public CarParkDetails(String parkingName, String  lpn, int  timeIn, int  timeOut, String color) {
    this.parkingName = parkingName;
    this.lpn = lpn;
    this.timeIn = timeIn;
    this.timeOut = timeOut;
    this.color = color;
  }

}