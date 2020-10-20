setblock -274 202 -302 lever[powered=false,face=wall,facing=west]
fill -275 202 -305 -279 202 -306 gravel
setblock -278 203 -306 gravel
fill -276 203 -306 -276 203 -305 gravel
setblock -276 204 -306 gravel

execute if score stage game_track matches 0 run function scripts:randomisers/5

execute if score var1 var matches 1 run fill -275 202 -305 -279 204 -306 sand replace gravel
execute if score var1 var matches 2 run fill -275 202 -305 -279 204 -306 red_sand replace gravel
execute if score var1 var matches 3 run fill -275 202 -305 -279 204 -306 anvil replace gravel
execute if score var1 var matches 4 run fill -275 202 -305 -279 204 -306 light_blue_concrete_powder replace gravel