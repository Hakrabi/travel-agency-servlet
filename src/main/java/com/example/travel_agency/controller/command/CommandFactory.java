package com.example.travel_agency.controller.command;

import com.example.travel_agency.controller.command.common.EditTourCommand;
import com.example.travel_agency.controller.command.common.LoginCommand;
import com.example.travel_agency.controller.command.page.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;



public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    private static Map<String, ICommand> commands = new HashMap<>();

    private CommandFactory() {}

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    static {
//    // common commands
        commands.put("tours", new ToursMainPageCommand());
        commands.put("userList", new UserListPageCommand());
        commands.put("tourList", new TourListPageCommand());
//    commands.put("pdf_builder", new PdfBuilderCommand());
//    commands.put("no_command", new NoCommand());
//    commands.put("i18n", new I18NCommand());
//    commands.put("redirect", null);
//
//    // admin commands
//    commands.put("main", new MainCommand());
//    commands.put("users", new ShowUserListCommand());
//    commands.put("services", new EditServicesCommand());
        commands.put("registration", new RegistrationPageCommand());
        commands.put("loginPage", new LoginPageCommand());
        commands.put("login", new LoginCommand());
        commands.put("editTourPage", new EditTourPageCommand());
        commands.put("editTour", new EditTourCommand());
        commands.put("singleTour", new SingleTourPageCommand());
//    commands.put("profile", new ProfileCommand());
//    commands.put("add_tariff", new AddTariffCommand());
//    commands.put("edit_tariff", new EditTariffCommand());
//    commands.put("remove_tariff", new RemoveTariffCommand());
//
//    // client commands
//    commands.put("account", new AccountCommand());
//    commands.put("personal_data", new PersonalDataCommand());
//    commands.put("user_profile", new UserProfileCommand());
//    commands.put("transactions", new TransactionCommand());
//    commands.put("save_profile", new SaveUserProfileCommand());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter("action");
        System.out.println(action);
        return commands.get(action);
    }
}
