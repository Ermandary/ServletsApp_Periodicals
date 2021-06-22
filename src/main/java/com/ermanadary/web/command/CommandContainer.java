package com.ermanadary.web.command;

import com.ermanadary.web.command.admin.AddPeriodicalCommand;
import com.ermanadary.web.command.admin.AdminPageCommand;
import com.ermanadary.web.command.admin.AdminProfileCommand;
import com.ermanadary.web.command.admin.BlockCommand;
import com.ermanadary.web.command.admin.DeletePeriodical;
import com.ermanadary.web.command.admin.EditPeriodical;
import com.ermanadary.web.command.admin.ShowUsersCommand;
import com.ermanadary.web.command.admin.UnblockCommand;
import com.ermanadary.web.command.client.ClientPageCommand;
import com.ermanadary.web.command.client.ClientProfileCommand;
import com.ermanadary.web.command.client.PaymentCommand;
import com.ermanadary.web.command.client.PaymentFormCommand;
import com.ermanadary.web.command.client.ShowSubscriptionsCommand;
import com.ermanadary.web.command.client.SubscribeCommand;
import com.ermanadary.web.command.client.TopUpBalanceCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private static final Logger log = LogManager.getLogger(CommandContainer.class);

    private static final Map<String, Command> commands = new HashMap<>();

    static {
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
        commands.put("noCommand", new DeletePeriodical());

        log.debug("Command container was successfully initialized");
        log.trace("Number of commands --> " + commands.size());
    }

    public static Command getCommand(String commandName) {
        if (commandName == null || !commands.containsKey(commandName)) {
            log.warn("Command not found, commandName ==> " + commandName);
            return commands.get("noCommand");
        }

        return commands.get(commandName);
    }
}
