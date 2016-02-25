package server.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Notification;

import server.repository.ServerRepository;
import server.model.Server;

@SpringUI
@Theme("valo")
public class ServerUI extends UI {
    private final ServerRepository repo;
    private final ServerForm form;
    private final Grid grid;
    private final TextField filter;
    private final Button btnAddNewServer;

    @Autowired
    public ServerUI(ServerRepository repo, ServerForm form) {
	this.repo = repo;
	this.form = form;
	this.grid = new Grid();
	this.filter = new TextField();
	this.btnAddNewServer = new Button("New server", FontAwesome.PLUS);
    }


    @Override
    protected void init(VaadinRequest request){
	HorizontalLayout actions = new HorizontalLayout(filter, btnAddNewServer);
	actions.setWidth("100%");
	filter.setWidth("100%");
	actions.setExpandRatio(filter, 1);

	VerticalLayout mainLayout = new VerticalLayout(actions, grid, form);
	mainLayout.setSizeFull();
	grid.setSizeFull();
	mainLayout.setExpandRatio(grid, 1);
	setContent(mainLayout);

	actions.setSpacing(true);
	mainLayout.setMargin(true);
	mainLayout.setSpacing(true);

	grid.setHeight(300, Unit.PIXELS);
	grid.setColumns("serverId", "serverDescription", "serverApplications", "serverStatus", "machineReadableName", "serverIP");
	filter.setInputPrompt("Filter by Application");

	filter.addTextChangeListener(e -> listServers(e.getText()));

	grid.addSelectionListener(e -> {
		if (e.getSelected().isEmpty()){
			form.setVisible(false);
		} else {
			form.editServer((Server) e.getSelected().iterator().next());
		}
	});

	btnAddNewServer.addClickListener(e -> form.editServer(new Server("", "", "", "", "")));
	form.setChangeHandler(() -> {
		form.setVisible(false);
		listServers(filter.getValue());
	});

	listServers(null);
    }

    private void listServers(String text) {
	if (StringUtils.isEmpty(text)) {
		grid.setContainerDataSource(new BeanItemContainer(Server.class, repo.findAll()));
	} else {
		// TODO implement findByApplication
	}
    }
}
