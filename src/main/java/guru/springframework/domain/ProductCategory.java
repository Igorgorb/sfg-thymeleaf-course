package guru.springframework.domain;

/**
 *
 * @author igorg
 * @date 15 серп. 2022 р.
 */
public class ProductCategory {

  private Integer id;
  private String category;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

}
