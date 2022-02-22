package com.example.travel_agency.controller.command;

import com.example.travel_agency.controller.command.get.*;
import com.example.travel_agency.controller.command.post.admin.AddTourCommand;
import com.example.travel_agency.controller.command.post.admin.BlockUserCommand;
import com.example.travel_agency.controller.command.post.admin.EditTourCommand;
import com.example.travel_agency.controller.command.post.common.AddReceiptCommand;
import com.example.travel_agency.controller.command.post.common.LoginCommand;
import com.example.travel_agency.controller.command.post.common.LogoutCommand;
import com.example.travel_agency.controller.command.post.common.RegistrationCommand;
import com.example.travel_agency.controller.command.post.moderator.EditReceiptStatusCommand;
import com.example.travel_agency.model.constants.Path;

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
        commands.put(Path.RECEIPT_LIST, new ReceiptListPageCommand());
        commands.put(Path.ADD_TOUR, new AddTourPageCommand());
        commands.put(Path.EDIT_TOUR, new EditTourPageCommand());

        //common
        commands.put(Path.LOGIN_ACTION, new LoginCommand());
        commands.put(Path.REGISTRATION_ACTION, new RegistrationCommand());
        commands.put(Path.LOGOUT_ACTION, new LogoutCommand());
        commands.put(Path.ADD_RECEIPT_ACTION, new AddReceiptCommand());

        //admin
        commands.put(Path.BLOCK_USER, new BlockUserCommand());
        commands.put(Path.EDIT_TOUR_ACTION, new EditTourCommand());
        commands.put(Path.ADD_TOUR_ACTION, new AddTourCommand());
        commands.put(Path.EDIT_RECEIPT_STATUS_ACTION, new EditReceiptStatusCommand());

    }

    public ICommand getCommand(HttpServletRequest request) {
        String path = request.getRequestURI();
//        String path = request.getPathInfo();
//        path = request.getMethod() + ':' + path;

//        System.out.println(path);
//        System.out.println(request.getRequestURI());
//        System.out.println(request.getServletPath());
//        System.out.println(request.getContextPath());

//        return commands.get(path);
        return commands.getOrDefault(path, (req,resp) -> Path.PAGE_ERROR_404);
    }
}
