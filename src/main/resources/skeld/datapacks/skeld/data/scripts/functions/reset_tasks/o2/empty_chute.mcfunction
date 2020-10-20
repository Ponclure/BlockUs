setblock -234 202 -346 lever[powered=false,face=wall,facing=west]
fill -235 202 -349 -239 202 -350 gravel
setblock -238 203 -350 gravel
fill -236 203 -350 -236 203 -349 gravel
setblock -236 204 -350 gravel

execute if score stage game_track matches 0 run function scripts:randomisers/5

execute if score var1 var matches 1 run fill -235 202 -349 -239 204 -350 sand replace gravel
execute if score var1 var matches 2 run fill -235 202 -349 -239 204 -350 red_sand replace gravel
execute if score var1 var matches 3 run fill -235 202 -349 -239 204 -350 anvil replace gravel
execute if score var1 var matches 4 run fill -235 202 -349 -239 204 -350 light_blue_concrete_powder replace gravel