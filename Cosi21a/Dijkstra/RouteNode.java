public class RouteNode extends Hashable{

  private double weight;
  private RouteNode predecessor;

  public RouteNode(){
    weight = Double.POSITIVE_INFINITY;
    predeccessor = null;
  }

  public double getWeight(){
    return weight;
  }

  public void setWeight(double weight){
    this.weight = weight;
  }

  public RouteNode getPredecessor(){
    return predecessor;
  }

  public void setPredecessor(RouteNode predecessor){
    this.predecessor = predecessor;
  }

  public double getNumRepresentation(){
    return weight;
  }
}
