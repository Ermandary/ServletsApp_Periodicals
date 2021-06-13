package com.ermanadary.web.command;

import com.ermanadary.web.command.admin.*;
import com.ermanadary.web.command.client.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private static final Map<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("login", new LoginCommand());
        commands.put("signup", new SignupCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("clientPage", new ClientPageCommand());
        commands.put("clientProfile", new ClientProfileCommand());
        commands.put("updateUser", new UpdateUserCommand());
        commands.put("adminPage", new AdminPageCommand());
        commands.put("adminProfile", new AdminProfileCommand());
        commands.put("subscribe", new SubscribeCommand());
        commands.put("showSubscriptions", new ShowSubscriptionsCommand());
        commands.put("mainPage", new MainPageCommand());
        commands.put("showUsers", new ShowUsersCommand());
        commands.put("payment", new PaymentCommand());
        commands.put("paymentForm", new PaymentFormCommand());
        commands.put("topUpBalance", new TopUpBalanceCommand());
        commands.put("block", new BlockCommand());
        commands.put("unblock", new UnblockCommand());
        commands.put("editPeriodical", new EditPeriodical());
        commands.put("addPeriodical", new AddPeriodicalCommand());
        commands.put("deletePeriodical", new DeletePeriodical());
    }

    public static Command getCommand(String comandName) {
        return commands.get(comandName);
    }
}
