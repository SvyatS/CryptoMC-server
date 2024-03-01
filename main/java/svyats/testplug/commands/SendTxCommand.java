package svyats.testplug.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendTxCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!this.commandValidation(sender, args)) {
            return false;
        }

        Player p = (Player) sender;
        p.sendMessage("You sended " + args[1] + " tokens to " + args[0]);

        return true;
    }

    public boolean commandValidation(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) return false;

        Player p = (Player) sender;
        if (args.length != 2) {
            p.sendMessage("Wrong arguments");
            p.sendMessage("Use /send-tx <nickname of recipient> <amount>");
            return false;
        }

        if (Bukkit.getServer().getPlayerExact(args[0]) == null) {
            p.sendMessage("ERROR: Player with this nickname not was found");
            return false;
        }

        try {
            Float amount = Float.parseFloat(args[1]);

        } catch (Exception e) {
            p.sendMessage("ERROR: amount is null or non decimal");
            return false;
        }

        return true;
    }
}
