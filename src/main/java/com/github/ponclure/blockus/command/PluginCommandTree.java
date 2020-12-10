package com.github.ponclure.blockus.command;

import java.util.HashSet;

public class PluginCommandTree {

    private SubCommand tree;
    public PluginCommandTree() {
        this.tree = new SubCommand("blockus", "/blockus", null, new HashSet<>());
        tree.getChildren().add(new SubCommand("create", "/blockus create", tree, new HashSet<>()));
        tree.getChildren().add(new SubCommand("join", "/blockus join", tree, new HashSet<>()));
        tree.getChildren().add(new SubCommand("leave", "/blockus leave", tree, new HashSet<>()));
        tree.getChildren().add(new SubCommand("list", "/blockus gui", tree, new HashSet<>()));
    }

    public SubCommand getTree() { return tree; }

}




