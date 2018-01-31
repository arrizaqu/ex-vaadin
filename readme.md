# Vaadin Framework
* Installation
* Hello world
* execution with jetty
* Button and Notification
* Layouting and TextField

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
https://github.com/vaadin/tutorial/

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

## Reference 
https://vaadin.com/docs/v8/framework/tutorial.html
https://github.com/vaadin/tutorial/
