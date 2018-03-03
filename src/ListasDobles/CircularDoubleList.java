package ListasDobles;

public class CircularDoubleList<T> {
  private Node<T> cabeza;
  private Node<T> cola;
    
  CircularDoubleList(){
    
    this.cabeza = this.cola = null;
    

  }
   
    

  public boolean isVacio(){

    return this.cabeza == null;
    
  }


  public void insertarCabeza(Node n){
    
    if(this.isVacio()){
      
      this.cabeza = n;
      
      this.cola = n;
   
      n.setNext(n);
      n.setPrev(n);   
    }else{
      
      n.setNext(this.cabeza);
      
      n.setPrev(this.cola);
      
      this.cabeza.setPrev(n);
      
      this.cola.setNext(n);
      
      this.cabeza = n;
    
    }
  
  }

    
  
  public void insertar(Node n, int i){
    
    if(this.isVacio() || i==0){
      
      this.insertarCabeza(n);
     
    }else if(i == this.contar()){
        
        this.insertarCola(n);
      
    }else if(i > this.contar()){
        
      System.out.println("ERROR!! Posicion inexistente");
      
    }else if(i < 0){
        
      insertar(n,i+this.contar());
      
    }else{

      Node aux = this.cabeza;
       
      int cont = 0;
       
      while(cont != i - 1){
         
        aux = aux.getNext();
         
        cont++;
       
      }
           
      n.setNext(aux.getNext());
         
      n.setPrev(aux);
         
      aux.getNext().setPrev(n);
        
      aux.setNext(n);
      
    }
     
  }


  public void insertarCola(Node n){
    
    if(this.isVacio()){
      
      this.cabeza = n;
      
      this.cola = n;
      
      n.setNext(n);
      n.setPrev(n);   
    }else{
      
      n.setNext(this.cabeza);
       
      n.setPrev(this.cola);
      
      this.cabeza.setPrev(n);
      
      this.cola.setNext(n);
      
      this.cola = n;
    
    }
  
  }


  public T eliminarCabeza(){
    
    if(this.isVacio()){
        
      return null;
    
    }else if(this.cabeza == this.cola){
      
      Node aux = this.cabeza;
      
      this.cabeza = this.cola = null;
      
      return (T) aux.getDato();
    
    }else{
      
      Node aux = this.cabeza;
            
      
      this.cabeza = this.cabeza.getNext();
      
      this.cola.setNext(this.cabeza);
      
      this.cabeza.setPrev(this.cola);
            
      
      return (T) aux.getDato();
    
    }
  
  }
    
  

  public T eliminar(int i){
    
    if(this.isVacio()){
      
      return null;
    
    }else{
      
      if(i == 0){
        
        return eliminarCabeza();
        
      }else if(i == (this.contar() - 1)){
          
        return this.eliminarCola();
        
      }else if(i > this.contar() - 1){
          
        System.out.println("ERROR!! Posici?n Inexistente");
            
        return null;
        
      }else if(i < 0){
          
        return this.eliminar(i + contar());
        
      }else{
    
        Node aux = this.cabeza;
 
        int cont = 0;
          
        
while(cont != i){
    
          aux = aux.getNext();
            
          cont++;
          
        }
     
        aux.getNext().setPrev(aux.getPrev()); 
 
       aux.getPrev().setNext(aux.getNext());
         
        return (T) aux.getDato();
        
      }
    
    }
  
  }

  public T eliminarCola(){
    
    if(this.isVacio()){      
      
        return null;
    
    }else if(this.cabeza == this.cola){
      
      Node aux = this.cola;
      
      this.cabeza = this.cola = null;
      
      return (T) aux.getDato();
    
    }else{
      
      Node aux = this.cola;
    
      this.cola = this.cola.getPrev();
      
      this.cola.setNext(this.cabeza);
      
      this.cabeza.setPrev(this.cola);
            
      
      return (T) aux.getDato();
    
    }
  
  }
    
  

  public int contar(){
    
    int cont=0;
    
    Node aux = this.cabeza;
    
    do{
        
      cont++;
      aux = aux.getNext();
      
    
    }while(aux != this.cabeza);
      
    return cont;
  
  }

}
