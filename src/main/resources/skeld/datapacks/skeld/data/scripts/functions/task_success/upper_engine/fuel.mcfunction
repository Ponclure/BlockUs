execute as @a[x=-250,y=201,z=-302,dx=6,dy=3,dz=1] at @s run playsound minecraft:task_completed master @s ~ ~ ~ 9999
clear @a[x=-250,y=201,z=-302,dx=6,dy=3,dz=1] bucket
tp @a[x=-250,y=201,z=-302,dx=6,dy=3,dz=1] @e[tag=upper_engine,tag=fuel,limit=1]

execute as @e[tag=upper_engine,tag=fuel,limit=1] run function scripts:decrement_task
function scripts:reset_tasks/upper_engine/fuel
