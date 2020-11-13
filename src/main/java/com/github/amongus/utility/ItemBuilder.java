package com.github.amongus.utility;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder implements Supplier<ItemStack> {

	private final List<BiConsumer<ItemStack, ItemMeta>> biconsumerList;

	private final Material material;

	public ItemBuilder(Material material) {
		this.biconsumerList = new LinkedList<>();
		this.material = material;
	}

	public ItemBuilder with(BiConsumer<ItemStack, ItemMeta> biconsumer) {
		biconsumerList.add(biconsumer);
		return this;
	}

	public ItemBuilder withIf(BiPredicate<ItemStack, ItemMeta> bipredicate,
			BiConsumer<ItemStack, ItemMeta> biconsumer) {
		return with((stack, meta) -> {
			if (bipredicate.test(stack, meta)) {
				biconsumerList.add(biconsumer);
			}
		});
	}

	public ItemBuilder withIfOrElse(BiPredicate<ItemStack, ItemMeta> bipredicate,
			BiConsumer<ItemStack, ItemMeta> ifTrue, BiConsumer<ItemStack, ItemMeta> ifFalse) {
		return with((stack, meta) -> {
			if (bipredicate.test(stack, meta)) {
				biconsumerList.add(ifTrue);
				return;
			}
			biconsumerList.add(ifFalse);
		});
	}

	public ItemBuilder withAmount(int amount) {
		return with((stack, meta) -> stack.setAmount(amount));
	}

	public ItemBuilder withName(String name) {
		return with((stack, meta) -> meta.setDisplayName(name));
	}

	public ItemBuilder withEnchant(Enchantment ench, int level, boolean ignoreLevelRestriction) {
		return with((stack, meta) -> meta.addEnchant(ench, level, ignoreLevelRestriction));
	}

	public ItemBuilder withLore(String... lore) {
		return with((stack, meta) -> meta.setLore(Arrays.asList(lore)));
	}

	@Override
	public ItemStack get() {
		ItemStack item = new ItemStack(material);
		ItemMeta meta = item.getItemMeta();
		biconsumerList.forEach(biconsumer -> biconsumer.accept(item, meta));
		item.setItemMeta(meta);
		return item;
	}
}
