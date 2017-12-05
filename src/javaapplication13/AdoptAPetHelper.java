/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication13;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author cadelmonterde
 */
public class AdoptAPetHelper  implements Iterable<AdoptAPetHelper.Node>
{
   private Node first;
   private Node last;
   
   /** 
      Constructs an empty queue.
   */
   public AdoptAPetHelper()
   {  
      first = null;
      last = null;
   }

   public void enqueue(Object element)
   {  
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = null;
      if (last != null)
      {
          last.next = newNode;
      }
      
      if (first == null)
      {
          first = newNode;
      }
      
      last = newNode;
   }

   public Object dequeue()
   {  
      if (first == null) { throw new NoSuchElementException(); }
      Object element = first.data;
      if (first == last)
      {
         last = null;
      }

      first = first.next;
      return element;
   }

   public boolean empty()
   {
      return first == null;
   }

 
    @Override
    public Iterator<Node> iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new NodeIterator();
    }


    class NodeIterator implements Iterator<Node>
    {
        private Node currents;
        @Override
        public boolean hasNext()
        {
            if(currents == null)
            {
                currents = first;
                return Optional.ofNullable(currents).isPresent();
            }
            else
            {
                currents = currents.next;
                return Optional.ofNullable(currents).isPresent();
            }
        }

        @Override
        public String toString() {
            return "NodeIterator{" + "currents=" + currents + '}';
        }
        
        @Override
        public Node next()
        {
            return currents;
        }
    }
   
   class Node
   {  
      public Object data;
      public Node next;

        @Override
        public String toString() {
            return data.toString();
        }
      
   }

    public Node getLast() {
        return first;
    }
    
static class Demo
{        
    AdoptAPetHelper cat = new AdoptAPetHelper();
    AdoptAPetHelper dog = new AdoptAPetHelper();
    AdoptAPetHelper shelterPet = new AdoptAPetHelper();
    AdoptAPetHelper foundAnimal = new AdoptAPetHelper();
    AdoptAPetHelper holdShelter = new AdoptAPetHelper();
    
   Scanner in = new Scanner(System.in);
   
   public void displayMenu ()
   {
       System.out.println("Select a chocie from the main menu: ");
       int userChoice = 0;
       
       while(userChoice != 7)
       {
           System.out.println("1.Donate a cat");
           System.out.println("2.Donate a dog");
           System.out.println("3.Adopt a Cat");
           System.out.println("4.Adopt a dog");
           System.out.println("5.Donate a pet");
           System.out.println("6.Adopt oldest Pet");
           System.out.println("7.Exit");
           userChoice = in.nextInt();
           
           switch (userChoice)
           {
               case 1:
               {
                   enqueueCats();
                   break;
               }
               case 2:
               {
                   enqueueDogs();
                   break;
               }
               case 3:
               {
                   dequeueCats();
                   break;
               }
               case 4:
               {
                   dequeueDogs();
                   break;
               }
               case 5:
               {
                   enqueueAnimals();
                   break;
               }
               case 6:
               {
                   dequeueAnimals();
                   break;
               }
               case 7:
               {
                   System.out.println("Eliminating program from mainframe matrix thingg..some crazy stuff!!!!");
                   break;
               }
               default:
               {
                   System.out.println("Note a Choice.......... ");
                   break;
               }
           
           }
       }
   }

   public void  enqueueCats()
   {
       System.out.println("what is the name of the cat you would like to donate");
       String catName = in.next();
       Pet catObj = new Pet(catName,"cat");
       cat.enqueue(catObj);
       shelterPet.enqueue(catObj);
   }

   public void enqueueDogs()
   {
       System.out.println("what is the name of the dog you would like to donate");
       String dogName = in.next();
       Pet dogObj = new Pet(dogName,"dog");
       dog.enqueue(dogObj);
       shelterPet.enqueue(dogObj);
   }

   public void dequeueCats()
   {
       Object catHolder = cat.dequeue();
       System.out.println("you just adopted "+ catHolder+"!!!");
       searchShelter(catHolder.toString());
       for(AdoptAPetHelper.Node s:cat)
       {
           System.out.println(s);
       }
       holdShelter = new AdoptAPetHelper();
   }
   
   public void dequeueDogs()
   {
       Object dogHolder = dog.dequeue();
       System.out.println("you just adopted "+ dogHolder+"!!!");
       searchShelter(dogHolder.toString());
       for(AdoptAPetHelper.Node s:dog)
       {
           System.out.println(s);
       }
       holdShelter = new AdoptAPetHelper();
   }

   public void enqueueAnimals()
   {
       System.out.println("Please enter a name for the pet youd like to donate.");
       String name = in.next();
       System.out.println("What kind of animal is it???(Dog...a cat????) ");
       String species = in.next();
       Pet pet = new Pet(name,species);
       shelterPet.enqueue(pet);
       if(species.equalsIgnoreCase("cat"))
       {
           cat.enqueue(pet);
       }
       else if(species.equalsIgnoreCase("dog"))
       {
           dog.enqueue(pet);
       }
   }
   
   public void searchShelter(String adptCat)
   {                
       while (!shelterPet.empty()) 
       {
           Object searchShelter = shelterPet.dequeue();
           //  System.out.println(search.toString());
           if (!searchShelter.toString().equalsIgnoreCase(adptCat)) 
           {
               holdShelter.enqueue(searchShelter);
           }
           else 
           {
           //    System.out.println("We found him");
               foundAnimal.enqueue(searchShelter);
           }
       }
       shelterPet = holdShelter;
   }


   public void dequeueAnimals()
   {
       System.out.println("Searching for the oldest animal in the linked list queue");
       
       Object last = shelterPet.dequeue();
       System.out.println("you just adopted "+ last+"!!!");
       Pet o = (Pet)last;
       if(o.getSpecies().equalsIgnoreCase("cat"))
       {
           cat.dequeue();
       }
       else if(o.getSpecies().equalsIgnoreCase("dog"))
       {
           dog.dequeue();
       }
       for(AdoptAPetHelper.Node s:shelterPet)
       {
           System.out.println(s);
       }
   }
}

static class Pet
{
        private String name;
    private String species;
    
    public Pet(String name,String species)
    {
        this.name = name;
        this.species = species;
    }
    

    public String getName()
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

 
    public String getSpecies() 
    {
        return species;
    }

    public void setSpecies(String species) 
    {
        this.species = species;
    }

    @Override
    public String toString()
    {
        return name.toString()+" its a "+species.toString()+"!!!!";
    }
    
    
}
    
}

