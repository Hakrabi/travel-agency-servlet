package com.example.travel_agency.controller.command;

import com.example.travel_agency.controller.Path;
import com.example.travel_agency.controller.command.common.AddTourCommand;
import com.example.travel_agency.controller.command.common.EditTourCommand;
import com.example.travel_agency.controller.command.common.LoginCommand;
import com.example.travel_agency.controller.command.common.LogoutCommand;
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
        //pages
        commands.put(Path.HOME, new ToursMainPageCommand());
        commands.put(Path.REGISTRATION, new RegistrationPageCommand());
        commands.put(Path.SINGLE_TOUR, new SingleTourPageCommand());
        commands.put(Path.LOGIN, new LoginPageCommand());
        commands.put(Path.USER_PROFILE, new UserProfilePageCommand());

        //admin pages
        commands.put(Path.USER_LIST, new UserListPageCommand());
        commands.put(Path.TOUR_LIST, new TourListPageCommand());
        commands.put(Path.ADD_TOUR, new AddTourPageCommand());
        commands.put(Path.EDIT_TOUR, new EditTourPageCommand());

        //common
        commands.put(Path.LOGIN_ACTION, new LoginCommand());
        commands.put(Path.LOGOUT_ACTION, new LogoutCommand());

        //admin
        commands.put(Path.EDIT_TOUR_ACTION, new EditTourCommand());
        commands.put(Path.ADD_TOUR_ACTION, new AddTourCommand());

    }

    public ICommand getCommand(HttpServletRequest request) {
        String path = request.getRequestURI();
//        path = request.getMethod() + ':' + path;

        System.out.println(path);
        return commands.getOrDefault(path, (req,resp) -> Path.PAGE_ERROR_404);



//        String action = request.getParameter("action");
//        System.out.println(action);
//        return commands.get(action);
    }
}
