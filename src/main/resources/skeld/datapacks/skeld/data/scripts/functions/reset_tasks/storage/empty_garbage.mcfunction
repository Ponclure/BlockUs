setblock -264 202 -324 lever[powered=false,face=wall,facing=west]
fill -269 202 -328 -265 202 -327 gravel
setblock -268 203 -328 gravel
fill -266 203 -328 -266 203 -327 gravel
setblock -266 204 -328 gravel

execute if score stage game_track matches 0 run function scripts:randomisers/5

execute if score var1 var matches 1 run fill -265 202 -327 -269 204 -328 sand replace gravel
execute if score var1 var matches 2 run fill -265 202 -327 -269 204 -328 red_sand replace gravel
execute if score var1 var matches 3 run fill -265 202 -327 -269 204 -328 anvil replace gravel
execute if score var1 var matches 4 run fill -265 202 -327 -269 204 -328 light_blue_concrete_powder replace gravel