fill -244 203 -324 -244 201 -323 air
fill -244 203 -324 -244 201 -323 minecraft:barrel[facing=west]{Items:[{Slot:13b,id:"minecraft:glass",Count:1b}]}
setblock -244 203 -324 air
setblock -245 202 -327 air

execute if score stage game_track matches 0 run function scripts:randomisers/5
execute if score var1 var matches 0 run clone -251 206 -322 -251 206 -322 -244 203 -323
execute if score var1 var matches 1 run clone -251 206 -322 -251 206 -322 -244 202 -323
execute if score var1 var matches 2 run clone -251 206 -322 -251 206 -322 -244 201 -323
execute if score var1 var matches 3 run clone -251 206 -322 -251 206 -322 -244 202 -324
execute if score var1 var matches 4 run clone -251 206 -322 -251 206 -322 -244 201 -324

clear @a[x=-250,y=201,z=-324,dx=6,dy=3,dz=1]