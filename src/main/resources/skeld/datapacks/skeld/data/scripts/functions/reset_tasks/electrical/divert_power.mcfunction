fill -300 202 -339 -294 202 -339 redstone_wire
execute if score stage game_track matches 0 run function scripts:randomisers/7

execute if score var1 var matches 0 run setblock -300 202 -339 air
execute if score var1 var matches 1 run setblock -299 202 -339 air
execute if score var1 var matches 2 run setblock -298 202 -339 air
execute if score var1 var matches 3 run setblock -297 202 -338 air
execute if score var1 var matches 4 run setblock -296 202 -339 air
execute if score var1 var matches 5 run setblock -295 202 -339 air
execute if score var1 var matches 6 run setblock -294 202 -339 air