public class Process implements Comparable{

  private Integer id;
  private Integer priority;
  private String name;

  public Process(Integer id, Integer priority, String name){
    this.id = id;
    this.priority = priority;
    this.name = name;
  }

  public Integer getID(){
    return id;
  }

  public Integer getPriority(){
    return priority;
  }

  public String getName(){
    return name;
  }

  public int compareTo(Object o){
    if(!(o instanceof Process)){
      throw new IllegalArgumentException();
    }
    Process other = (Process) o;
    return priority - other.getPriority();
  }
}
