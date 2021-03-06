package my.vaadin.app;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    
    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);
    Grid<User> dataGrid = new Grid<User>(User.class);
    
    private TextField filterText = new TextField();
    private CustomerForm form = new CustomerForm(this);

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
    
   
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
    	//datatable with grid
    	List<User> listUser= this.getAllUser();
    
    	//filter Grid column
    	this.dataGrid.setColumns("name","address", "jobDesc");
    	
    	//layouting
    	VerticalLayout layout = new VerticalLayout();
    	layout.addComponent(this.dataGrid);
    	this.dataGrid.setItems(listUser);
    	
    	layout.setMargin(true);
    	layout.setSpacing(true);
    	setContent(layout);
    	/*final VerticalLayout layout = new VerticalLayout();

        filterText.setPlaceholder("filter by name...");
        filterText.addValueChangeListener(e -> updateList());
        filterText.setValueChangeMode(ValueChangeMode.LAZY);

        Button clearFilterTextBtn = new Button(FontAwesome.TIMES);
        clearFilterTextBtn.setDescription("Clear the current filter");
        clearFilterTextBtn.addClickListener(e -> filterText.clear());

        CssLayout filtering = new CssLayout();
        filtering.addComponents(filterText, clearFilterTextBtn);
        filtering.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCustomer(new Customer());
        });

        HorizontalLayout toolbar = new HorizontalLayout(filtering, addCustomerBtn);

        grid.setColumns("firstName", "lastName", "email");

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSizeFull();
        grid.setSizeFull();
        main.setExpandRatio(grid, 1);

        layout.addComponents(toolbar, main);

        // fetch list of Customers from service and assign it to Grid
        updateList();

        setContent(layout);

        form.setVisible(false);

        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() == null) {
                form.setVisible(false);
            } else {
                form.setCustomer(event.getValue());
            }
        });*/
    }

    public void updateList() {
        List<Customer> customers = service.findAll(filterText.getValue());
        grid.setItems(customers);
    }
    
    public void setDataGrid(){
    	List<User> listUser = this.getAllUser();
    	this.dataGrid.setItems(listUser);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
