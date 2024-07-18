# Serialization & Deserialization 

## **Introduction**

Serialization is a mechanism to convert the state of an object into a byte stream. Deserialization is the reverse process where the byte stream is used to recreate the actual Java object in memory. This mechanism is used to persist the object. The created byte stream is independent of any platform. So, the object serialized on one platform can be deserialized on a different platform. A Java object is made Serializable by implementing the java.io.Serializable interface. The ObjectOutputStream class contains a method, writeObject(), for serializing an Object. The ObjectInputStream class contains the readObject() method, which has to be used for deserializing an object.

##  **Benefits of Serialization**

- Persistence: Objects can be saved to a file or a database, by which the object state can be preserved for successive runs of a program.

- Data Exchange: Applications running on different machines, irrespective of the OS, can exchange serialized objects. This helps to increase the interoperability and communication between different applications or application components better over a network in a distributed computing environment.

- Caching:serialized objects are stored in a cache implementation, hence a way to avoid repeated calculation or recreation of such objects, thus improving performance of applications.

- Deep Copy: Serialization provides a way to create deep copies of objects, which is useful if an application needs an exact copy of an object with all its referred objects.

- Platform Independence: Data serialized on one platform—for example, a Java application—can be deserialized on any other platform, such as a Python application. This streamlines interoperability.

## **Benefits of Deserialization**

- Reconstruction of Objects:Deserialization allows for the reconstruction of objects from their serialized format, bringing them back as they are and restoring their character behavior.

- Flexibility:Deserialization is the basis for creating new objects on the fly. It is done by defining an object by the input data and dynamically "loading" the object in the application memory manipulating it after that. This is useful in cases where the exact types of objects are not known at compile time. We can dynamically load objects using deserialization at runtime to craft extender and eliminating of the objects not known a compile time.

- Data Recovery:Deserialization is a means to extract objects from persistent storage and fix the problem of lost data in sessions between desktops and client-side web applications.

- Configuration: Complex configuration settings can be stored in serialized form and deserialized when needed, making it easier to manage application configurations.

## **Mechanism of the Scope**

Serialization in Java is the process of converting an object's state into a byte stream. In such a byte stream, all the information about the object is maintained. Usually used in Hibernate, JMS, JPA, and EJB, serialization in Java facilitates carrying the code from one JVM to another and then de serializes it there.

### *Serialization Process*
- Marking the Class as Serializable: To enable serialization of a class a class needs to implement the interface Serializable

- Creating an Output Stream: The class, which needs to be serialized, instantiates the ObjectOutputStream class to constitute a stream. This involves wrapping of the instance, wrapping of the instance around a lower-level byte stream, like a FileOutputStream.

- Writing the Object: Writing of an object to the stream involves the use of the incredibly simple writeObject method.

### *Deserialization Process*
- Getting a reference to the disk to create a FileInputStream.

- Reading the Object: The object is read from the stream by a method readObject.

- Casting the Object: The object read is cast into its original type.

## **Hypothetical Scenario**

### *User Management in a Web Application*

Consider you are developing a web application by the name "Student Management Portal," where the users are supposed to register and log in. There are user data, such as username and password, that needs to be serialized into session storage or sent from server to client.

