execute as @a[x=-300,y=201,z=-313,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
tp @a[x=-300,y=201,z=-313,dx=6,dy=3,dz=1] @e[tag=reactor,tag=unlock_manifolds,limit=1]

execute as @e[tag=reactor,tag=unlock_manifolds,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/reactor/unlock_manifolds