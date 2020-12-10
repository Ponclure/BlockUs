package com.github.ponclure.blockus.command;

import com.github.ponclure.blockus.BlockUsPlugin;
import org.bukkit.command.Command;

import java.util.Set;
import java.util.Stack;

class SubCommand {

    private final String arg;          // argument
    private final String permission;   // permission for command
    private final String usage;        // if used incorrectly, show this
    private final SubCommand parent;   // parent
    private Set<SubCommand> children;  // sub commands

    public SubCommand(String arg, String usage, SubCommand parent, Set<SubCommand> children) {
        this.arg = arg;
        this.permission = generatePermissionNode();
        this.usage = usage;
        this.parent = parent;
        this.children = children;
    }

    private String generatePermissionNode() {
        StringBuilder sb = new StringBuilder();
        SubCommand recurse = parent;
        while (recurse.parent != null) {
            sb.insert(0, '.' + recurse.arg);
            recurse = recurse.parent;
        }
        return "blockus" + sb.toString();
    }

    public String getArgument() {
        return arg;
    }

    public String getPermission() {
        return permission;
    }

    public String getUsage() {
        return usage;
    }

    public Set<SubCommand> getChildren() {
        return children;
    }

    public static SubCommand findSubCommand(Command command) {
        Stack<SubCommand> stack = new Stack<>();
        stack.add(BlockUsPlugin.getBlockUs().getCommandTree().getTree());
        while (stack.size() > 0) {
            SubCommand cmd = stack.pop();
            if (cmd.getPermission().equals(command.getPermission())) {
                return cmd;
            } else {
                for (SubCommand child : cmd.getChildren()) {
                    stack.add(child);
                }
            }
        }
        return null;
    }

}