package server.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

import java.io.*;

import server.repository.ServerRepository;
import server.model.Server;

@SpringComponent
@UIScope
public class ServerForm extends VerticalLayout {

	private final ServerRepository repo;

	private Server server;

	BeanFieldGroup<Server> formFieldBindings;

	/* Fields to edit properties in Server entity */
	TextField serverDescription = new TextField("Description");
	TextArea serverApplications = new TextArea("Applications");
	TextField serverStatus = new TextField("Status");
	TextField machineReadableName = new TextField("Machine Name");
	TextField serverIP = new TextField("IP");

	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel", this::cancel);
	Button access = new Button("Access Server");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, access, delete);

	@Autowired
	public ServerForm(ServerRepository repo) {
		this.repo = repo;
		serverApplications.setWidth("100%");
		serverApplications.setMaxLength(1500);
		addComponents(serverDescription, serverApplications, serverStatus, machineReadableName, serverIP, actions);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

		// wire action buttons to save, delete and reset
		save.addClickListener(e->save(server));
		delete.addClickListener(e->delete(server));
		access.addClickListener(e->access(server));
		setVisible(false);
	}

	public void save(Server server) {
		try {
			formFieldBindings.commit();
			repo.save(server);
			String msg = String.format("Saved '%s %s'.",
				server.getServerDescription(),
				server.getMachineReadableName());
			Notification.show(msg,Type.TRAY_NOTIFICATION);
		} catch (FieldGroup.CommitException e) {
			// Validation exceptions could be shown here
		}
	}

	public void delete(Server server){
		try{
			formFieldBindings.commit();
			repo.delete(server);
			String msg = String.format("Deleted '%s %s'.",
				server.getServerDescription(),
				server.getMachineReadableName());
			Notification.show(msg,Type.TRAY_NOTIFICATION);
		} catch (FieldGroup.CommitException e){
			//Validation exception could be show here
		}
	}

	public void access(Server server){
		//TODO Create a ssh connection with the server machine
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editServer(Server s) {
		final boolean persisted = s.getServerId() != null;

		if (persisted) {
			server = repo.findOne(s.getServerId());
		}
		else {
			server = s;
		}
		cancel.setVisible(persisted);

		formFieldBindings = BeanFieldGroup.bindFieldsUnbuffered(server, this);

		setVisible(true);

		save.focus();
		serverDescription.selectAll();
	}

	public void cancel(Button.ClickEvent event) {
		Notification.show("Cancelled", Type.TRAY_NOTIFICATION);
		editServer(new Server("", "", "", "", ""));
	}

	public void setChangeHandler(ChangeHandler h) {
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
