package server.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import server.repository.ServerRepository;
import server.model.Server;

@SpringComponent
@UIScope
public class ServerForm extends VerticalLayout {

	private final ServerRepository repo;

	private Server server;

	/* Fields to edit properties in Server entity */
	TextField serverDescription = new TextField("Description");
	TextField serverApplications = new TextField("Applications");
	TextField serverStatus = new TextField("Status");
	TextField serverMachineReadableName = new TextField("Machine Name");
	TextField serverIP = new TextField("IP");

	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	@Autowired
	public ServerForm(ServerRepository repo) {
		this.repo = repo;

		addComponents(serverDescription, serverApplications, serverStatus, serverMachineReadableName, serverIP);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repo.save(server));
		delete.addClickListener(e -> repo.delete(server));
		cancel.addClickListener(e -> editServer(server));
		setVisible(false);
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

		BeanFieldGroup.bindFieldsUnbuffered(server, this);

		setVisible(true);

		save.focus();
	}

	public void setChangeHandler(ChangeHandler h) {
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
