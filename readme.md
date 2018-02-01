# Vaadin Framework
* Installation
* Hello world
* execution with jetty
* Button and Notification
* Layouting and TextField
* Data populate with Grid
	* Filter Column

## Installation 
## Hello world 
```java
public class MyUI extends UI {
	@Override
    protected void init(VaadinRequest vaadinRequest) {
        
    	//vaadin hello world
    	Label mylabel = new Label("vaadin hello world!!");
    	setContent(mylabel);
	}
}
```

## Button and Notification 
```java
Button button = new Button("click me!");
button.addClickListener(e -> Notification.show("hello world from button"));
setContent(button);
```

## execution with jetty
	mvn jetty:run

## Layouting and TextField
```java
//vaadin hello world
TextField textField = new TextField("name");
//layouting
VerticalLayout layout = new VerticalLayout();

Button button = new Button("click me!");
button.addClickListener(e -> Notification.show("hello "+ textField.getValue()));
setContent(button);

layout.addComponent(textField);
layout.addComponent(button);
layout.setMargin(true);
layout.setSpacing(true);
setContent(layout);
```

# Data populate with Grid
## example datasource 
```java
public List<User> getAllUser(){
	List<User> listUser = new ArrayList();
	User user1 = new User();
	User user2 = new User();
	User user3 = new User();
	User user4 = new User();
	User user5 = new User();
	User user6 = new User();
	
	user1.setId("1");
	user1.setAddress("seputih banyak");
	user1.setJobDesc("training");
	user1.setName("arrizaqu@yahoo.com");
	
	user2.setId("2");
	user2.setAddress("metro");
	user2.setJobDesc("finance");
	user2.setName("danang");
	
	user3.setId("3");
	user3.setAddress("datang");
	user3.setJobDesc("bendahara");
	user3.setName("agung");
	
	user4.setId("4");
	user4.setAddress("jakarta tangerang");
	user4.setJobDesc("developer");
	user4.setName("arrizaqu@yahoo.com");
	
	user5.setId("5");
	user5.setAddress("jakarta barat");
	user5.setJobDesc("long distance");
	user5.setName("bundo");
	
	user6.setId("6");
	user6.setAddress("sulawesi");
	user6.setJobDesc("Bambang sinr");
	user6.setName("lulu tobing");
	
	listUser.add(user1);
	listUser.add(user2);
	listUser.add(user3);
	listUser.add(user4);
	listUser.add(user5);
	listUser.add(user6);
	
	return listUser;
}
```

## example
```java
Grid<User> dataGrid = new Grid<User>(User.class)
 
@Override
protected void init(VaadinRequest vaadinRequest) {
	
	//datatable with grid
	List<User> listUser= this.getAllUser();
	
	//layouting
	VerticalLayout layout = new VerticalLayout();
	layout.addComponent(this.dataGrid);
	this.dataGrid.setItems(listUser);
	
	layout.setMargin(true);
	layout.setSpacing(true);
	setContent(layout);
}
```

## Filter Column
```java
//filter Grid column
this.dataGrid.setColumns("name","address", "jobDesc");
```

## Reference 
https://vaadin.com/docs/v8/framework/tutorial.html
https://github.com/vaadin/tutorial/